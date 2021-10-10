function logout() {
	if (confirm("로그아웃 하시겠습니까??") == true) {
		$.ajax({
			url: "/logout.do",
			type: "POST",
			dataType: "JSON",
			success: function(result) {
				alert("로그아웃");
				location.href = "/";
			}
		})
	}


}