<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="logreg-forms">
	<form action="signup" class="form-signup" method="post" style="display: block;">
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
		<h1 class="h3 mb-3 font-weight-normal mg-bot-2rem"
			style="text-align: center">Register</h1>
		<div class="form-group input-group" style="height: 48px">
			<div class="input-group-prepend" style="height: 100%">
				<span class="input-group-text"> <i class="fa fa-user"></i>
				</span>
			</div>
			<input id="name" name="name" class="form-control"
				placeholder="User name" type="text" style="height: 100%">
		</div>
		<!-- form-group// -->
		<p id="nameRemind" class="remind">Please enter your user name</p>
		<div class="form-group input-group" style="height: 48px">
			<div class="input-group-prepend" style="height: 100%">
				<span class="input-group-text"> <i class="fa fa-envelope"></i>
				</span>
			</div>
			<input id="email" name="email" class="form-control"
				placeholder="Email address" type="email" style="height: 100%">
		</div>
		<!-- form-group// -->
		<p id="emailRemind" class="remind">Please enter your email address</p>
		<div class="form-group input-group" style="height: 48px">
			<div class="input-group-prepend" style="height: 100%">
				<span class="input-group-text"> <i class="fa fa-lock"></i>
				</span>
			</div>
			<input id="password" name="password" class="form-control"
				placeholder="Create password" type="password" style="height: 100%">
		</div>
		<!-- form-group// -->
		<p id="passwordRemind" class="remind">Please enter your password</p>
		<div class="form-group input-group" style="height: 48px">
			<div class="input-group-prepend" style="height: 100%">
				<span class="input-group-text"> <i class="fa fa-lock"></i>
				</span>
			</div>
			<input id="repeat_password" name="repeat_password"
				class="form-control" placeholder="Repeat password" type="password"
				style="height: 100%">
		</div>
		<!-- form-group// -->
		<p id="repeatPasswordRemind" class="remind">The entered passwords
			do not match</p>
		<div class="form-group mg-top-2rem">
			<button type="submit" name="action" value="createAccount"
				class="btn btn-primary btn-block" id="register"
				onclick="return valiData();">Tạo tài khoản</button>
		</div>
		<!-- form-group// -->
		<p class="text-center">
			<a href="login" id=btn-signup>Đăng nhập</a>
		</p>
	</form>
</div>