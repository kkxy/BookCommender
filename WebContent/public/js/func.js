function changeHref(id, href) {
	var itemname=document.getElementById("inputitemname").value;
	document.getElementById(id).href=href+"&itemname="+itemname;
}

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

function putwishcart(type,id) {
	$.ajax({
		type: 'POST',
		url: 'wishcart',
		data: {
			bookid: id
		},
		dataType: 'json',
		success: function(data) {
			if (data.result == 'success') {
				var btn = document.getElementById(type+"buybtn_" + data.id);
				btn.disabled="disabled";
				btn.innerHTML="已借";
				if (type == 'reco') {
					var mainbtn = document.getElementById("mainbuybtn_" + data.id);
					mainbtn.disabled="disabled";
					mainbtn.innerHTML="已借";
				}
				alert('借书成功');
			}
			else {
				alert('借书失败');
			}
		}
	})
}

function computerecom() {
	$.ajax({
		type: 'POST',
		url: 'computerecom',
		dataType: 'json',
		success: function(data) {
			alert("计算完成");
		}
	})
}