# KTP API Specification

## Base URL

```
http://localhost:8080
```

---

# 1. Create KTP

### Endpoint

```
POST /ktp
```

### Request Body

```json
{
  "nomorKtp": "1234567890123456",
  "namaLengkap": "Fina Novita",
  "alamat": "Yogyakarta",
  "tanggalLahir": "2002-05-09",
  "jenisKelamin": "Perempuan"
}
```

### Response Body (Success)

```json
{
  "id": 1,
  "nomorKtp": "1234567890123456",
  "namaLengkap": "Fina Novita",
  "alamat": "Yogyakarta",
  "tanggalLahir": "2002-05-09",
  "jenisKelamin": "Perempuan"
}
```

### Response Body (Failed)

Jika nomor KTP sudah ada:

```json
{
  "message": "Nomor KTP sudah ada"
}
```

Jika data tidak valid:

```json
{
  "message": "Nomor KTP tidak boleh kosong"
}
```

---

# 2. Get All Data KTP

### Endpoint

```
GET /ktp
```

### Response Body (Success)

```json
[
  {
    "alamat": "Yogyakarta",
    "id": 1,
    "jenisKelamin": "Perempuan",
    "namaLengkap": "Fina Novita",
    "nomorKtp": "1234567890123456",
    "tanggalLahir": "2002-05-09"
  },
  {
    "alamat": "Yogyakarta",
    "id": 2,
    "jenisKelamin": "Perempuan",
    "namaLengkap": "Anggita",
    "nomorKtp": "1234567890987654",
    "tanggalLahir": "2002-07-31"
  },
  {
    "alamat": "Ponorogo",
    "id": 3,
    "jenisKelamin": "Laki-Laki",
    "namaLengkap": "Samudra",
    "nomorKtp": "1234567891087654",
    "tanggalLahir": "2006-10-06"
  }
]
```

---

# 3. Get KTP By ID

### Endpoint

```
GET /ktp/{id}
GET /ktp/1
```

### Response Body (Success)

```json
{
  "id": 1,
  "nomorKtp": "1234567890123456",
  "namaLengkap": "Fina Novita",
  "alamat": "Yogyakarta",
  "tanggalLahir": "2002-05-09",
  "jenisKelamin": "Perempuan"
}
```

### Response Body (Failed)

Jika data tidak ditemukan:

```json
{
  "message": "Data tidak ditemukan"
}
```

---

# 4. Update Data KTP

### Endpoint

```
PUT /ktp/{id}
PUT /ktp/1
```

### Request Body

```json
{
  "nomorKtp": "1234567890123456",
  "namaLengkap": "Fina Novita Ramadhani",
  "alamat": "Balikpapan",
  "tanggalLahir": "2005-10-09",
  "jenisKelamin": "Perempuan"
}
```

### Response Body (Success)

```json
{
  "alamat": "Balikpapan",
  "id": 1,
  "jenisKelamin": "Perempuan",
  "namaLengkap": "Fina Novita Ramadhani",
  "nomorKtp": "1234567890123456",
  "tanggalLahir": "2005-10-09"
}
```

### Response Body (Failed)

Jika data tidak ditemukan:

```json
{
  "message": "Data tidak ditemukan"
}
```

---

# 5. Delete Data KTP

### Endpoint

```
DELETE /ktp/{id}
DELETE /ktp/2
```

### Response Body (Success)

```json
{
  "message": "Data berhasil dihapus"
}
```

### Response Body (Failed)

Jika data tidak ditemukan:

```json
{
  "message": "Data tidak ditemukan"
}
```


---
# Screenshot

## Tampilan Halaman Web

<img width="1915" height="1014" alt="Tampilan halaman web KTP" src="https://github.com/user-attachments/assets/304e7dd7-b35e-441d-8624-4d009424f365" />

## Tambah Data KTP

<img width="1919" height="1009" alt="Tambah data KTP" src="https://github.com/user-attachments/assets/17a5f429-a005-42ab-9336-6b0b109be3b1" />

## Update Data KTP

<img width="1915" height="1006" alt="Update data KTP" src="https://github.com/user-attachments/assets/a925ee2a-6cf7-4c66-bcb4-ff7f37223862" />

## Delete Data KTP

<img width="1919" height="1006" alt="Delete data KTP" src="https://github.com/user-attachments/assets/0d92f37e-24c9-4cdd-b8a2-79c539ea2785" />

## Database MySQL

<img width="1561" height="750" alt="Tampilan Database" src="https://github.com/user-attachments/assets/b1363fef-4ff7-490c-8a24-caa2c57ba83d" />

---

**Fina Novita Ramadhani**
NIM: 20230140169
