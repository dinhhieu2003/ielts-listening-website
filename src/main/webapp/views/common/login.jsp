<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<body>
<div id="logreg-forms">
    <form class="form-signin" action="login" method="post">
        <div class="row">
            <div class="col">
                <c:if test="${not empty message}">
                    <div class="alert alert-success">${message}</div>
                </c:if>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>
            </div>
        </div>
        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">ĐĂNG NHẬP</h1>
        <input name="user" type="text" class="form-control" placeholder="Username" style="margin-bottom: 8px" value = ${user}>
        <input name="pass" type="password" class="form-control" placeholder="Password">

        <button class="btn btn-success btn-block" type="submit" name="action" value="signin">
            <i class="fas fa-sign-in-alt"></i>Đăng nhập
        </button>
        <input type="checkbox" name="remember" id="">
    	<label for="">Nhớ tôi</label>
        <a href="#" id="forgot_pswd">Quên mật khẩu ?</a>
        <hr>
        <!-- <p>Don't have an account!</p>  -->
        <button class="btn btn-primary btn-block" id="btn-signup">
            <i class="fas fa-user-plus"></i> <a href="<%=request.getContextPath()%>/login" style="display: inline-block; color: white">Đăng ký tài khoản mới</a>
        </button>
    </form>

    <form action="forgot" method="post" class="form-reset">
        <input type="hidden" name="action" value="enterOTP">
        <input id="resetEmail" name="resetEmail" type="email" class="form-control" placeholder="Email address" required="" autofocus="">
        <button class="btn btn-primary btn-block" type="submit">Xác nhận</button>
        <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>
    </form>

    <form action="signup" class="form-signup" method="post">
        <h1 class="h3 mb-3 font-weight-normal mg-bot-2rem" style="text-align: center">Register</h1>
        <div class="form-group input-group" style="height: 48px">
            <div class="input-group-prepend" style="height: 100%">
                <span class="input-group-text"> <i class="fa fa-user"></i> </span>
            </div>
            <input id="name" name="name" class="form-control" placeholder="User name" type="text" style="height: 100%">
        </div> <!-- form-group// -->
        <p id="nameRemind" class="remind">Please enter your user name</p>
        <div class="form-group input-group" style="height: 48px">
            <div class="input-group-prepend" style="height: 100%">
                <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
            </div>
            <input id="email" name="email" class="form-control" placeholder="Email address" type="email"
                   style="height: 100%">
        </div> <!-- form-group// -->
        <p id="emailRemind" class="remind">Please enter your email address</p>
        <div class="form-group input-group" style="height: 48px">
            <div class="input-group-prepend" style="height: 100%">
                <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
            </div>
            <input id="password" name="password" class="form-control" placeholder="Create password" type="password"
                   style="height: 100%">
        </div> <!-- form-group// -->
        <p id="passwordRemind" class="remind">Please enter your password</p>
        <div class="form-group input-group" style="height: 48px">
            <div class="input-group-prepend" style="height: 100%">
                <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
            </div>
            <input id="repeat_password" name="repeat_password" class="form-control" placeholder="Repeat password"
                   type="password" style="height: 100%">
        </div> <!-- form-group// -->
        <p id="repeatPasswordRemind" class="remind">The entered passwords do not match</p>
        <div class="form-group mg-top-2rem">
            <button type="submit" name="action" value="createAccount" class="btn btn-primary btn-block" id="register" onclick="return valiData();" >
                Tạo tài khoản
            </button>
        </div> <!-- form-group// -->
        <p class="text-center"><a href="" id=btn-signup>Đăng nhập</a></p>
    </form>
    <br>

</div>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    function toggleResetPswd(e) {
        e.preventDefault();
        $('#logreg-forms .form-signin').toggle() // display:block or none
        $('#logreg-forms .form-reset').toggle() // display:block or none
    };

    function toggleSignUp(e) {
        e.preventDefault();
        $('#logreg-forms .form-signin').toggle(); // display:block or none
        $('#logreg-forms .form-signup').toggle(); // display:block or none
    };

    $(() => {
        // Login Register Form
        $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
        $('#logreg-forms #cancel_reset').click(toggleResetPswd);
        $('#logreg-forms #btn-signup').click(toggleSignUp);
        $('#logreg-forms #cancel_signup').click(toggleSignUp);
    });

    function valiData() {
        // Kiểm tra thông tin mà người dùng nhập vào
        // Nếu chưa đủ thì yêu cầu người dùng nhập lại
        var result = true;
        if (document.getElementById('name').value == '') {
            document.getElementById('nameRemind').style.visibility = 'visible';
            result = false;
        } else {
            document.getElementById('nameRemind').style.visibility = 'hidden';
        }

        if (document.getElementById('email').value == '') {
            document.getElementById('emailRemind').style.visibility = 'visible';
            result = false;
        } else {
            document.getElementById('emailRemind').style.visibility = 'hidden';
        }

        if (document.getElementById('password').value == '') {
            document.getElementById('passwordRemind').style.visibility = 'visible';
            result = false;
        } else {
            document.getElementById('passwordRemind').style.visibility = 'hidden';

            //Kiểm tra Repeat Password có giống với Password chưa ?
            if (document.getElementById('repeat_password').value.trim() != document.getElementById('password').value.trim()) {
                document.getElementById('repeatPasswordRemind').style.visibility = 'visible';
                result = false;
            } else {
                document.getElementById('repeatPasswordRemind').style.visibility = 'hidden';
            }
        }

        return result;
    }
</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>