$(function(){
    $('[rel="tooltip"]').tooltip();
    $('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});
});