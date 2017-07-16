$('#update').on('show.bs.modal',function(e) {
	//get data-id attribute of the clicked element
	var id = $(e.relatedTarget).data('id');
	var userId = $(e.relatedTarget).data('user-id');
	var shopname = $(e.relatedTarget).data('shopname');
	//populate the textbox
	$(e.currentTarget).find('input[name="id"]').val(id);
	$(e.currentTarget).find('input[name="userId"]').val(userId);
	$(e.currentTarget).find('input[name="shopname"]').val(shopname);
});
