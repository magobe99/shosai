 function Login(){ 
        var done=0; 
        var usuario=document.login.usuario.value; 
        var password=document.login.password.value; 
        if (usuario=="administrador" && password=="administrador1") { 
        window.location="administrador.html"; 
        } 
        if (usuario=="cliente" && password=="cliente1") { 
        window.location="cliente.html"; 
        } 
        if (usuario=="empleado" && password=="empleado1") { 
        window.location="empleado.html"; 
        } 
        } 

