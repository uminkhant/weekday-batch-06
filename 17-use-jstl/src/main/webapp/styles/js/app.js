const myModal = document.getElementById('addNewBtn')
		const modal = document.getElementById('modal')
		
		myModal.addEventListener('click', () => {
			const dialog = new bootstrap.Modal(modal)
			dialog.show()
		})