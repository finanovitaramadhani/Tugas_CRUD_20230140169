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


**Fina Novita Ramadhani**
NIM: 20230140169
