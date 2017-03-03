function changeAction(id, action) {
	document.getElementById(id).action=action;
}


function changeClass(type, changetype) {
	var select = document.getElementById(type+"typeid");
	var index = select.selectedIndex;
	var key = select.options[index].value;
	$.ajax({
		type: 'POST',
		url: 'getselectclass',
		data: {
			typeid: key
		},
		dataType: 'json',
		success: function(data) {
					var w_select = document.getElementById(changetype+"typeid");
					for (var i = 0; i < w_select.length; ) {
						var child = w_select[i];
						w_select.removeChild(w_select[i])
					}
					
					var classlist = data.classlist;
					for (var i = 0; i < classlist.length; i++) {
						var child = document.createElement("option");
						var text = document.createTextNode(classlist[i].name);
						child.value = classlist[i].itemid;
						child.nodeValue = classlist[i].name;
						child.appendChild(text);
						w_select.appendChild(child);
					}
						
				}
	})
}

function putwishcart(id) {
	$.ajax({
		type: 'POST',
		url: 'wishcart',
		data: {
			bookid: id
		},
		dataType: 'json',
		success: function(data) {
			if (data.type == 'success')
				alert('加入成功');
			else
				alert('加入失败')
		}
	})
}