import { useEffect, useState } from "react"

const initialDataForm = {
    id: 0,
    name: '',
    description: '',
    price: ''
}

// eslint-disable-next-line react/prop-types
export const ProductForm = ({productSelected, handlerAdd}) => {

    const [form, setForm] = useState(initialDataForm);
    const {id, name, description, price } = form;
    useEffect (() => {
        setForm(productSelected)
    }, [productSelected]);
    return (
        <form onSubmit={(event) => {
            event.preventDefault();
            if(!name || !description || !price) {
               alert("Debe completar los datos del formulario!") 
               return;
            }

            //console.log(initialDataForm)
            handlerAdd(form)
            setForm(initialDataForm);
        }}>
            <input className="form-control mb-3" placeholder="Name" name="name" value={name}
                onChange={(event) => setForm({
                    ...form,
                    name: event.target.value
                })}></input>

            <input className="form-control mb-3" placeholder="Description" name="description" value={description}
                onChange={(event) => setForm({
                    ...form,
                    description: event.target.value
                })}></input>

            <input className="form-control mb-3"placeholder="Price" name="price" value={price}
                onChange={(event) => setForm({
                    ...form,
                    price: event.target.value
                })}></input>

                <button type="submit" className="btn btn-primary">
                    {id > 0 ? 'Update' : 'Create'}
                </button>
        </form>
    )
}