const myModal = document.getElementById('addNewBtn')
const modal = document.getElementById('modal')
		
		myModal.addEventListener('click', () => {
			const dialog = new bootstrap.Modal(modal)
			dialog.show()
		})
		
		
		
const login = document.getElementById('login')
const formLogin = document.getElementById('formLogin')
		
		login.addEventListener('click', () => {
			const dialog = new bootstrap.Modal(formLogin)
			dialog.show()
		})
		
		