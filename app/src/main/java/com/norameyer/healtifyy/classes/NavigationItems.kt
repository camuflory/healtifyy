import com.norameyer.healtifyy.R

// класс, отвечающий за нижнюю навигацию
sealed class NavigationItems(
    var route: String,
    var icon: Int,
    var title: String
) {
    object Pressure : NavigationItems("pressure", R.drawable.pressure, "давление")
    object Pills : NavigationItems("pills", R.drawable.pills, "таблетки")
    object Sugar : NavigationItems("sugar", R.drawable.sugar, "сахар")
    object Add : NavigationItems("add", R.drawable.add, "добавить")
}