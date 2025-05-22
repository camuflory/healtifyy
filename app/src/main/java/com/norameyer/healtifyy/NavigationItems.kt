package com.norameyer.healtifyy



// класс, отвечающий за нижнюю навигацию
sealed class NavigationItems(
    var route: String,
    var icon: Int,
    var title: String
) {
    object Pressure : NavigationItems("pressure", R.drawable.pressure, "pressure")
    object Pills : NavigationItems("pills", R.drawable.pills, "pills")
    object Sugar : NavigationItems("sugar", R.drawable.sugar, "sugar")
}