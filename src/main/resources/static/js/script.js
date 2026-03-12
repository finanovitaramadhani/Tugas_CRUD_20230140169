const API = "http://localhost:8080/ktp";

$(document).ready(function(){
loadData();
});

function showAlert(message,type){

$("#message").html(
`<div class="alert alert-${type} alert-dismissible fade show mt-3">
${message}
<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
</div>`
);

}

function loadData(){

$.get(API,function(data){

let rows="";

data.forEach(function(item){

rows += `
<tr>
<td>${item.id}</td>
<td>${item.nomorKtp}</td>
<td>${item.namaLengkap}</td>
<td>${item.alamat}</td>
<td>${item.tanggalLahir}</td>
<td>${item.jenisKelamin}</td>

<td>

<button class="btn btn-warning btn-sm"
onclick="editData(${item.id})">Edit</button>

<button class="btn btn-danger btn-sm"
onclick="deleteData(${item.id})">Delete</button>

</td>

</tr>
`;

});

$("#tableKtp").html(rows);

});

}

function saveData(){

let id=$("#id").val();

let data={
nomorKtp:$("#nomorKtp").val(),
namaLengkap:$("#namaLengkap").val(),
alamat:$("#alamat").val(),
tanggalLahir:$("#tanggalLahir").val(),
jenisKelamin:$("#jenisKelamin").val()
};

if(id==""){

$.ajax({

url:API,
type:"POST",
contentType:"application/json",
data:JSON.stringify(data),

success:function(){

showAlert("Data berhasil ditambahkan","success");

loadData();
resetForm();

},

error:function(){

showAlert("Gagal menambahkan data","danger");

}

});

}else{

$.ajax({

url:API+"/"+id,
type:"PUT",
contentType:"application/json",
data:JSON.stringify(data),

success:function(){

showAlert("Data berhasil diperbarui","success");

loadData();
resetForm();

},

error:function(){

showAlert("Gagal memperbarui data","danger");

}

});

}

}

function editData(id){

$.get(API+"/"+id,function(data){

$("#id").val(data.id);
$("#nomorKtp").val(data.nomorKtp);
$("#namaLengkap").val(data.namaLengkap);
$("#alamat").val(data.alamat);
$("#tanggalLahir").val(data.tanggalLahir);
$("#jenisKelamin").val(data.jenisKelamin);

});

}

function deleteData(id){

if(confirm("Yakin ingin menghapus data?")){

$.ajax({

url:API+"/"+id,
type:"DELETE",

success:function(){

showAlert("Data berhasil dihapus","warning");

loadData();

},

error:function(){

showAlert("Gagal menghapus data","danger");

}

});

}

}

function resetForm(){

$("#id").val("");
$("#nomorKtp").val("");
$("#namaLengkap").val("");
$("#alamat").val("");
$("#tanggalLahir").val("");
$("#jenisKelamin").val("Laki-laki");

}
