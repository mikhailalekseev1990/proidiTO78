$(document).ready(function(){
    /* Smooth scroll */
    $('[data-scroll]').on('click', function(){
        $('[data-scroll]').removeClass('active');
        $(this).addClass('active');
        var block = $(this).attr('data-scroll');
       $('html, body').animate({
                scrollTop: $('.' + block).offset().top-125  
            }, 1000); 
    });


    /* Burger Menu */

$('.navToggle').on('click', function(){
$('.navToggleItem').toggleClass('active');
$('.nav').toggleClass('active');
});




/* Mail */
    
$("#sendMail").on("click", function() {

    var message = $("#text").val().trim();

    if(message == "") {
        $("#errorMess").text("Введите вопрос");
        return false;
    } 
    $("#errorMess").text("");

    $.ajax({
        url: 'mail.php',
        type: 'POST',
        cache: false,
        data: { 'message': message },
        dataType: 'html',
        beforeSend: function() {
            $("#sendMail").prop("disabled", true);    
        },
        success: function(data) {
            alert(data);
            $("#sendMail").prop("disabled", false);
        }
    });
});


});
