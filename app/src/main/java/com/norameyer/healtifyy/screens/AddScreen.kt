import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import MainViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable

fun AddScreen(mvm: MainViewModel = viewModel(factory = MainViewModel.factory)) {


    val options = listOf("Левая", "Правая")
    var expanded by remember { mutableStateOf(false) }



    Scaffold(
        topBar = { TopBar("Добавить запись") },
        backgroundColor = Color(0xFFF2FFF9)
    ) {


        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // PRESSURE
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp, bottom = 15.dp),
                value = mvm.textPressure.value,
                onValueChange = { mvm.textPressure.value = it },
                label = { Text(text = "давление", color = Color.Gray) },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            // ARM
            ExposedDropdownMenuBox(expanded, onExpandedChange = { expanded = !expanded }) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(15.dp),
                    value = mvm.textArm.value,
                    onValueChange = { mvm.textArm.value = it },
                    label = { Text("рука", color = Color.Gray) },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                    maxLines = 1
                )
                ExposedDropdownMenu(expanded, onDismissRequest = { expanded = false }) {
                    options.forEach { selectedArm ->
                        DropdownMenuItem(
                            text = { Text(selectedArm) },
                            onClick = {
                                mvm.textArm.value = selectedArm
                                expanded = false
                            }
                        )
                    }
                }
            }

            //SUGAR
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(15.dp),
                value = mvm.textSugar.value,
                onValueChange = { mvm.textSugar.value = it },
                label = { Text("сахар", color = Color.Gray) },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )


//PILLS NAME
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(15.dp),
                value = mvm.textPills.value,
                onValueChange = { mvm.textPills.value = it },
                label = { Text("таблетки", color = Color.Gray) },
                maxLines = 1

            )

            //PILLS AMOUNT
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(15.dp),
                value = mvm.textDose.value,
                onValueChange = { mvm.textDose.value = it },
                label = { Text("дозировка", color = Color.Gray) },
                maxLines = 1
            )

            Button(
                onClick = {
                    mvm.insertPressure()
                    mvm.insertSugar()
                    mvm.insertPills()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF7DB797))
            ) { Text(text = "Добавить запись") }
        }
    }
}