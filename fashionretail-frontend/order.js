let faker = require('faker');

let generateOrders = () => {
    let orders = [];

    for (let id = 0; id < 30; id++) {
        let customer_name = faker.name.firstName();
        let material = faker.commerce.productMaterial();
        let unit = faker.lorem.word();
        let quantity = faker.random.number();

        orders.push({
            "id": id,
            "customer_name": customer_name,
            "material": material,
            "unit": unit,
            "quantity": quantity
        });
    }

    return { "orders": orders }
}

module.exports = generateOrders
