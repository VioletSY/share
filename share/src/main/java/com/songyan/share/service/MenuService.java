package com.songyan.share.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.songyan.share.dao.MenuDao;
import com.songyan.share.util.Validate;

/**
 * @author songyan
 * @date 2020年3月22日
 * @desc: 菜单
 */
@Service
public class MenuService {
	@Autowired
	private MenuDao dao;

	public List<Map<String, Object>> getMenuListnew() {
		/* 获取一级菜单 */
		List<Map<String, Object>> yjcd = dao.getYjcdList();
		/* 循环一级菜单，获取二级菜单 */
		for (Map<String, Object> map : yjcd) {
			if (Validate.isNull(map.get("MURL"))) {// 为空说明不需要跳转到页面
				List<Map<String, Object>> ejcd = dao.getEjcdList(map.get("MGID") + "");
				Map<String, Object> ejcd_map = new HashMap<String, Object>();
				if (ejcd.isEmpty()) {// 二级菜单是空，说明一级菜单是末级
					map.put("ISLEAF", true);
				} else {
					/* 循环二级级菜单，获取三级菜单 */
					for (int j = 0; j < ejcd.size(); j++) {
						ejcd_map = ejcd.get(j);
						List<Map<String, Object>> sjcd = dao.getSjcdList(ejcd_map.get("MGID") + "");
						Map<String, Object> sjcd_map = new HashMap<String, Object>();
						if (sjcd.isEmpty()) {
							if (Validate.isNull(ejcd_map.get("MURL"))) {
								ejcd.remove(ejcd_map);
								j--;
							} else {
								ejcd_map.put("ISLEAF", true);
							}
						} else {
							if (sjcd.size() == 1) {// 如果三级菜单只有一个，则把三级菜单的信息绑到二级上
								if (ejcd.size() == 1) {// 如果二级也只有一个，则把三级菜单的信息直接绑到一级上
									sjcd_map = sjcd.get(0);
									map.put("MGID", sjcd_map.get("MGID") + "");
									map.put("MNAME", sjcd_map.get("MNAME") + "");
									map.put("MCLASS", sjcd_map.get("MCLASS") + "");
									map.put("MURL", sjcd_map.get("MURL") + "");
									map.put("ISLEAF", true);
									ejcd.remove(ejcd_map);
								} else {
									sjcd_map = sjcd.get(0);
									ejcd_map.put("MGID", sjcd_map.get("MGID") + "");
									ejcd_map.put("MNAME", sjcd_map.get("MNAME") + "");
									ejcd_map.put("MCLASS", sjcd_map.get("MCLASS") + "");
									ejcd_map.put("MURL", sjcd_map.get("MURL") + "");
									ejcd_map.put("ISLEAF", true);
								}
							} else {
								ejcd_map.put("ISLEAF", false);
								ejcd_map.put("children", sjcd);
								/* 循环三级菜单，如果有三级，三级为末级 */
								for (int k = 0; k < sjcd.size(); k++) {
									sjcd_map = sjcd.get(k);
									sjcd_map.put("ISLEAF", true);
								}
							}
						}
					}
					// 循环二级菜单的时候，可能会修改二级菜单内的信息，所以要循环完了之后放进去
					map.put("ISLEAF", ejcd.size() == 0);
					if (ejcd.size() > 0) {
						map.put("children", ejcd);
					}
				}
			} else {
				map.put("ISLEAF", true);
			}
		}
		return yjcd;
	}
}
