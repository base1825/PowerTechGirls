package za.co.varsitycollege.st10480736.qwimi.poe

object Cart  {





        // Store each service with its price
        val selectedServices = arrayListOf<Pair<String, Int>>() // Pair<ServiceName, Price>

        fun addService(name: String, price: Int) {
            selectedServices.add(Pair(name, price))
        }

        fun clearCart() {
            selectedServices.clear()
        }

}
