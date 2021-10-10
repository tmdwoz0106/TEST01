function remove() {
	if (confirm("정말 삭제하시겠습니까??") == true) {
		$.ajax({
			url: "/UserDelete.do",
			type: "POST",
			data: $("#deleteForm").serialize(),
			dataType: "JSON",
			success: function(result) {
				alert("회원 탈퇴");
				location.href = "/";
			}
		})
	}
}