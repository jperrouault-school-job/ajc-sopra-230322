const usernameInput = document.querySelector('input[name="username"]');

usernameInput.addEventListener('keyup', () => {
  const username = usernameInput.value;
  const paragraphe = document.querySelector('#username');

  paragraphe.innerHTML = username;
});