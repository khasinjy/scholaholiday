$(document).ready(function(){

    $("input.noter").hover(function(){
        $(this).animate({opacity: '1'});
      },
      function(){
        $(this).animate({opacity: '0.5'});
    }); 
    
    $("body").on('click',"input.noter",function() {
        var note_donnee = $(this).val();
        var id_media = $(this).data("id_media");
        $.ajax({
            url: "../php/noter.php",
            type: 'POST',
            data: {note_donnee:note_donnee, id_media:id_media }, 
            success: function(result){
                alert(result);
                window.location.reload();
            }
        });
    })

    $("input.fav").hover(function(){
        $(this).animate({opacity: '1'});
      },
      function(){
        $(this).animate({opacity: '0.5'});
    }); 
    $("body").on('click',"input.fav[name='add_fav']",function() {
        var id_media = $(this).data("id_media");
        $.ajax({
            url: "../php/add_favoris.php",
            type: 'POST',
            data: {id_media:id_media }, 
            success: function(result){
                alert(result);
                window.location.reload();
            }
        });
    })
    $("body").on('click',"input.fav[name='delete_fav']",function() {
        var id_media = $(this).data("id_media");
        $.ajax({
            url: "../php/delete_favoris.php",
            type: 'POST',
            data: {id_media:id_media  }, 
            success: function(result){
                alert(result);
                window.location.reload();
            }
        });
    })

    $("body").on('click',"button[name='del_media']",function() {
        var id_media = $(this).data("id_media");
        $.ajax({
            url: "../php/delete_media.php",
            type: 'POST',
            data: {id_media:id_media  }, 
            success: function(result){
                alert(result);
                window.location.reload();
            }
        });
    })

    $("body").on('click',"button[name='details']",function() {
        var id_media = $(this).data("id_media");
        $.ajax({
            url: "../php/details_media.php",
            type: 'POST',
            data: {id_media:id_media  }, 
            success: function(result){
                alert(result);
                window.location.reload();
            }
        });
    })

})
