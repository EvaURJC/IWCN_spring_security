$(document).on('click', '#boton', function() {

        if( ($("#codigo").val() != "") && ($("#nombre").val().length >= 3) && ($("#descripcion").val() >= 3) && ($("#precio").val().length >= 1) ){
            return true;
        }
	
        else if( ($("#codigo").val() == "") && (!isNaN($('#codigo').val())) ) {
	        $("#codigo").focus().after("<p> Minimo 1 numero sin letras </p>");
	        return false;
	    }

        else if( $("#nombre").val().length < 3) {
	        $("#nombre").focus().after("<p> Minimo 3 caracteres </p>");
	        return false;
	    }
        
        else if( $("#descripcion").val().length < 3) {
	        $("#descripcion").focus().after("<p> Minimo 3 caracteres </p>");
	        return false;
	    }
        
        else if ( (($('#precio').val().length) < 1) && (!isNaN($('#precio').val())) ){
	        $("#precio").focus().after("<p> Minimo 1 numero sin letras </p>");
	        return false;
	    }

});