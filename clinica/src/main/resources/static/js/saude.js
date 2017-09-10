$('#cancelarCadastro').on('show.bs.modal', function(event){
    var button = $(event.relatedTarget);
    var modal = $(this);
    var form = modal.find('form');
    form.attr('/secretaria');
    modal.find('.modal-body span').html('Tem certeza que deseja cancelar o cadastro? ');
});