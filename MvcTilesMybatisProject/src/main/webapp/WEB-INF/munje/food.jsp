<%--
  Created by IntelliJ IDEA.
  User: yang-mac
  Date: 2020/12/24
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        html {
            font-family: sans-serif;
        }

        form {
            width: 600px;
            background: #ccc;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid black;
        }

        form ol {
            padding-left: 0;
        }

        form li, div > p {
            background: #eee;
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
            list-style-type: none;
            border: 1px solid black;
        }

        form img {
            height: 64px;
            order: 1;
        }

        form p {
            line-height: 32px;
            padding-left: 10px;
        }

        form label, form button {
            background-color: #7F9CCB;
            padding: 5px 10px;
            border-radius: 5px;
            border: 1px ridge black;
            font-size: 1.2em;
            height: auto;
        }

        form label:hover, form button:hover {
            background-color: #2D5BA3;
            color: white;
        }

        form label:active, form button:active {
            background-color: #0D3F8F;
            color: white;
        }
    </style>
    <script type="text/javascript">
        $(function () {


            const input = $("#image_uploads")[0];
            const preview = $(".preview")[0];

            // input.style.opacity = 0;

            input.addEventListener('change', updateImageDisplay);
            // input.change(updateImageDisplay);

            // https://developer.mozilla.org/en-US/docs/Web/Media/Formats/Image_types
            const fileTypes = [
                'image/apng',
                'image/bmp',
                'image/gif',
                'image/jpeg',
                'image/pjpeg',
                'image/png',
                'image/svg+xml',
                'image/tiff',
                'image/webp',
                `image/x-icon`
            ];

            function validFileType(file) {
                return fileTypes.includes(file.type);
            }

            function returnFileSize(number) {
                if (number < 1024) {
                    return number + 'bytes';
                } else if (number > 1024 && number < 1048576) {
                    return (number / 1024).toFixed(1) + 'KB';
                } else if (number > 1048576) {
                    return (number / 1048576).toFixed(1) + 'MB';
                }
            }

            function updateImageDisplay() {
                while (preview.firstChild) {
                    preview.removeChild(preview.firstChild);
                }

                const curFiles = input.files;
                if (curFiles.length === 0) {
                    const para = document.createElement('p');
                    para.textContent = 'No files currently selected for upload';
                    preview.appendChild(para);
                } else {
                    const list = document.createElement('ol');
                    preview.appendChild(list);

                    for (const file of curFiles) {
                        const listItem = document.createElement('li');
                        const para = document.createElement('p');

                        if (validFileType(file)) {
                            para.textContent = "File name " + file.name + ", file size " + returnFileSize(file.size) + ".";
                            const image = document.createElement('img');
                            image.src = URL.createObjectURL(file);

                            listItem.appendChild(image);
                            listItem.appendChild(para);
                        } else {
                            para.textContent = "File name " + file.name + ": Not a valid file type. Update your selection.";
                            listItem.appendChild(para);
                        }

                        list.appendChild(listItem);
                    }
                }
            }
        });
    </script>

</head>
<body>
food.jsp<br>

<form action="munje" method="post" enctype="multipart/form-data">
    <b>product</b><br>
    name :<br>
    <input type="text" name="name" placeholder="input product name."><br><br>
    cnt : <br>
    <input type="number" min="1" max="10" value="1" name="cnt"><br><br>
    price : <br>
    <input type="number" min="0" max="10000" step="100" value="1000" name="price"><br><br>
    photos :<br>
    <div>
        <label for="image_uploads">Choose images to upload (PNG, JPG)</label>
        <input type="file" name="photos" id="image_uploads" name="image_uploads" accept=".jpg, .jpeg, .png" multiple>
    </div>
    <div class="preview">
        <p>No files currently selected for upload</p>
    </div>

    <button type="button" id="product-submit-btn">save product</button>
</form>

<div id="product-list">

</div>

</body>
</html>
