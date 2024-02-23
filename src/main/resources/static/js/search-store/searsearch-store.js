
function searchFunction() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById('keyword');
	filter = input.value.toUpperCase();
	table = document.getElementById('dynamic_table');
	tr = table.getElementsByTagName('tr');

	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName('td')[0]; // 첫 번째 열(매장명)에 대해서만 검색
		if (td) {
			txtValue = td.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = ''; // 해당 데이터는 보이도록 함
			} else {
				tr[i].style.display = 'none'; // 검색어와 맞지 않는 데이터는 숨김
			}
		}
	}
}