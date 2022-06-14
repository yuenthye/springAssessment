const createHTMLList = (title, description, targetDate) =>
`
<div class="col-lg-4">
<div class="card" style="width: 18rem;">
    <div class="card-body">
        <h5 class="card-title">${title}</h5>
        <p class="card-text">${description}</p>
        <p class="card-text">${targetDate}</p>
    </div>
</div>
</div>

`;


class ListController
{
    constructor()
    {
        this._items = [];       //create an array to store the details of product items
    }

    addList(title, description, targetDate)
        {

                var ListController = this;
                const formData = new FormData();
                formData.append('title', title);
                formData.append('description', description);
                formData.append('targetDate', targetDate);


                fetch('http://localhost:8080/todolist/add', {
                    method: 'POST',
                    body: formData
                    })
                    .then(function(response) {
                        console.log(response.status); // Will show you the status
                        if (response.ok) {
                            alert("Successfully Added To-Do!")
                               }
                               else {
                               throw Error(response.statusText);
                               }
                            })
                            .catch((error) => {
                                console.error('Error:', error);
                                alert("Error adding task to To-Do")
                            });

        }


                    displayList()
                        {
                            let ListController = this;
                            ListController._items = [];

                            //fetch data from database using the REST API endpoint from Spring Boot
                            fetch('http://127.0.0.1:8080/todolist/all')
                                .then((resp) => resp.json())
                                .then(function(data) {
                                    console.log("2. receive data")
                                    console.log(data);
                                    data.forEach(function (item, index) {

                                        const listObj = {
                                            title: item.title,
                                            description: item.description,
                                            targetDate: item.targetDate

                                       };
                                        ListController._items.push(listObj);
                                  });

                      ListController.renderListPage();

                    })
                    .catch(function(error) {
                    // console.log(error);
                    });
            }



            renderListPage ()
                {
                    let listHTMLList = [];

                    for (let i=0; i<this._items.length; i++)
                    {
                        const item = this._items[i];            //assign the individual item to the variable

                        const listHTML = createHTMLList(item.title, item.description, item.targetDate, i);

                        listHTMLList.push(listHTML);
                    }

                    //Join all the elements/items in my productHTMLList array into one string, and seperate by a break
                    const pHTML = listHTMLList.join('\n');
                    document.querySelector('#row').innerHTML = pHTML;

                    }
                    }


