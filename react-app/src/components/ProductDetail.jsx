import { PropTypes } from "prop-types";

export const ProductDetail = ({ handlerProductSelected, handlerRemove, product = {} }) => {

    return (
        <tr>
            <td>{product.id}</td>
            <td>{product.name}</td>
            <td>{product.description}</td>
            <td>{product.price}</td>
            <td>
                <button className="btn btn-secondary" onClick={() => handlerProductSelected(product)}>Update</button>
            </td>
            <td>
                <button className="btn btn-danger" onClick={() => handlerRemove(product.id)}>REMOVE</button>
            </td>
        </tr>
    )
}

ProductDetail.propTypes = {
    product: PropTypes.object.isRequired,
    handlerRemove: PropTypes.func.isRequired,
    handlerProductSelected: PropTypes.func.isRequired

}