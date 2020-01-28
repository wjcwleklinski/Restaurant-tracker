$(document).ready(function(){
      var fav = 'test';
      $('p').click(function() {
          var favJSON = JSON.stringify(fav);
          $.ajax({
            url: 'http://192.168.0.105:8080/user',
            method: 'POST',
            data: favJSON,
            contentType: "application/json; charset=utf-8"

          })
      })
  });
