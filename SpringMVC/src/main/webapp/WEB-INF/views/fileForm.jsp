<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>File Uploading</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<div class="container-fluid">
  <h1>Upload Form</h1>
</div>
    <form action="uploadimage" method="post" enctype="multipart/form-data">
      <div class="form-group">
        <label for="exampleFormControlFile1">Example image input</label>
        <input type="file" name="profile" class="form-control-file" id="exampleFormControlFile1">
        <button class="btn btn-outline-success">Upload</button>
      </div>
    </form>
</div>

</body>
</html>
