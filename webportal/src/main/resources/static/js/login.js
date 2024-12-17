document.addEventListener("DOMContentLoaded", function () {
        const passwordField = document.getElementById("password");
        const confirmPasswordField = document.getElementById("confirmPassword");
        const togglePassword = document.getElementById("togglePassword");
        const toggleConfirmPassword = document.getElementById("toggleConfirmPassword");
		
		if(togglePassword!=null){
        togglePassword.addEventListener("click", function () {
            // Toggle the type attribute
            const type = passwordField.type === "password" ? "text" : "password";
            passwordField.type = type;

            // Toggle the icon (optional if using a text icon like 👁️)
            togglePassword.textContent = type === "password" ? "👁️" : "🙈";
        });
		}
		
		if(toggleConfirmPassword!=null){
        toggleConfirmPassword.addEventListener("click", function () {
            // Toggle the type attribute
            const type = confirmPasswordField.type === "password" ? "text" : "password";
            confirmPasswordField.type = type;

            // Toggle the icon (optional if using a text icon like 👁️)
            toggleConfirmPassword.textContent = type === "password" ? "👁️" : "🙈";
        });
		}
    });