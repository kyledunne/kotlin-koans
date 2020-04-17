// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products } // orders.flatMap(Order::products)

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =
        customers.flatMap { it.orders.flatMap { it.products } }.toSet()
