$('#update')
	.on('show.bs.modal',function(e) {
		//get data-id attribute of the clicked element
		var id = $(e.relatedTarget).data('id');
		var purchasename = $(e.relatedTarget).data('purchasename');
		var categoryname = $(e.relatedTarget).data('categoryname');
		var shopname = $(e.relatedTarget).data('shopname');
		var price = $(e.relatedTarget).data('price');
		//populate the textbox and set value in lists
		$(e.currentTarget).find('input[name="id"]').val(id);
		$(e.currentTarget).find('input[name="purchasename"]').val(purchasename);
		$(e.currentTarget).find('input[name="price"]').val(price);
		$(e.currentTarget).find('select[name="categoryname"]').val(categoryname);
		$(e.currentTarget).find('select[name="shopname"]').val(shopname);
});