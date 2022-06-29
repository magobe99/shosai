/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function guadar(){
       let producto = document.getElementById("producto");
    let nproducto = document.getElementById("nproducto");
    let cantidad = document.getElementById("cantidad");
    let precio = document.getElementById("precio");
    let seleccion = document.getElementById("seleccion"); 
    
        
    if( producto.value === "" || nproducto.value === "" ||  cantidad.value === "" ||
             precio.value === "" ||  seleccion.value === ""   ){
    swal("Eror!", "Completa todos los campos!", "error");    
    }
    else {
       swal("GUARDADO!", "producto guardado con exito!", "success");
  
    }
    
}

function eliminar(){
       
 swal({
  title: "¿esta seguro?",
  text: "una vez eliminado no podra recuperarlo!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
        .then((eliminar) => {
  if (eliminar) {
    swal("Poof! Your imaginary file has been deleted!", {
      icon: "success",
    });
  } else {
    swal("Your imaginary file is safe!");
  }
});
    
}


