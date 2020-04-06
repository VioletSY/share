/**
 * 格式化性别
 * @param data
 * @returns {String}
 */
function handleSex(data){
	var sex = data.sex;
	if(sex=='01'){
		return '男'
	}else if(sex=='02'){
		return '女'
	}
	return '未知';
}

/**
 * 格式化头像
 * @param data
 * @returns {String}
 */
function handleHeadImage(data){
	var sex = data.sex;
	var img = '/img/tx.jpg'
	if(sex=='02'){
		img = '/img/tx_n.jpg'
	}
	return '<img src="'+img+'" class="headImageInTable"/>';
}

/**
 * 添加新用户
 */
function addUser(){
	window.location.href='/user/addUser';
}