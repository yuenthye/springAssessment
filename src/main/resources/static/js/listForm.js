const listControl = new ListController();

newListForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const newtoDolisttitle = document.querySelector('#newtoDolisttitle');
    const newtoDolistdescription = document.querySelector('#newtoDolistdescription');
    const newtoDolisttargetDate = document.querySelector('#newtoDolisttargetDate');


        const title = newtoDolisttitle.value;
        const description = newtoDolistdescription.value;
        const targetDate = newtoDolisttargetDate.value;


    newtoDolisttitle.value = '';
    newtoDolistdescription.value = '';
    newtoDolisttargetDate.value = '';


     listControl.addList(title, description, targetDate);

     });