import { useEffect, useState } from "react"
import listProduct from "../services/ProductService";
import { ProductGrid } from "./ProductGrid";
import { ProductForm } from "./ProductForm";


export const ProductApp = () => {

    const [products, setProducts] = useState([]);

    const [productSelected, setProductSelected] = useState({
        id: 0,
        name: '',
        description: '',
        price: ''
    });


    useEffect(() => {
        const result = listProduct();
        setProducts(result);
    }, []);

    const handlerAddProduct = (product) => {
        console.log(product);
        if (product.id > 0) {
            setProducts(products.map(prod => {
                if (prod.id == product.id) {
                    return { ...product }
                }
                return prod;
            }))
        } else {
            setProducts([...products, { ...product, id: new Date().getTime() }])
        }

    }
    const handlerRemoveProduct = (id) => {
        console.log(name);
        setProducts(products.filter(user => user.id != id))
    }

    const handlerProductSelected = (product) => {
        setProductSelected({ ...product })
    }
    return (
        <>
            <h1>Lista de Productos:</h1>
            <div className="row container">
                <div className="col">
                    <ProductForm handlerAdd={handlerAddProduct} productSelected={productSelected} />
                </div>
                <div className="col">
                    {
                        products.length > 0 ? <ProductGrid products={products} handlerRemove={handlerRemoveProduct} handlerProductSelected={handlerProductSelected} /> : <div className="alert alert-warning">No hay datos en el sistema</div>
                    }
                </div>
            </div>
        </>
    )
}