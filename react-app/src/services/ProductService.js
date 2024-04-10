import axios from "axios";

const products = [
    {
        id: 1,
        name: "Monitor Sansung",
        price: 500,
        description: "Alguna descripcion"
    },
    {
        id: 2,
        name: "Monitor Sansung2",
        price: 500,
        description: "Alguna descripcion2"
    }
]

const baseUrl = 'http://localhost:8080/products';

export const listProduct = () => {
    return products;
}

export const findAll = async () => {
    try {
        const response = await axios.get(baseUrl);
        return response;
    } catch (error) {
        console.log(error);
    }
    return null;
}

export const create = async ({ name, description, price }) => {
    try {
        const response = await axios.post(baseUrl, {
            name,
            description,
            price
        });
        return response;
    } catch (error) {
        console.log(error);
    }
    return undefined;
}

export const update = async ({ id, name, description, price }) => {
    try {
        //const response = await axios.put(baseUrl + '/' + id, {
            const response = await axios.put(`${baseUrl}/${id}`, {
            name,
            description,
            price
        });
        return response;
    } catch (error) {
        console.log(error);
    }
    return undefined;
}


export const remove = async (id) => {
    try {
        await axios.delete(`${baseUrl}/${id}`);
    } catch (error) {
        console.log(error);
    }
}