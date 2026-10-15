package com.example.mytesting5
// import studiondroit
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytesting5.ui.theme.MyTesting5Theme

// class main activity testing
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTesting5Theme {
                BiodataScreen()
            }
        }
    }
}
//composable option biodatascreen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BiodataScreen() {
    // State untuk input form
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var isAndroidChecked by remember { mutableStateOf(false) }
    var isUiUxChecked by remember { mutableStateOf(false) }
    var isWebChecked by remember { mutableStateOf(false) }

    // Scaffold utama
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        // Box Utama yang menampung Background dan Card yang mengapung
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 1. Bagian Background Gambar bachira.jpg di atas (penambahan gambar)
            Image(
                painter = painterResource(id = R.drawable.bachira),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.Crop
            )

            // 2. Komponen Box yang Mengapung di atas Scaffold/Background komponen box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.850f)
                    .align(Alignment.BottomCenter)
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(colorResource(id = R.color.card_background))
                    .padding(24.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Judul Form teks dan lainnya
                    Text(
                        text = stringResource(id = R.string.form_title),
                        fontSize = 28.sp,
                        color = colorResource(id = R.color.purple_title),
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Subtitle berbagai teks
                    Text(
                        text = stringResource(id = R.string.form_subtitle),
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.text_subtitle)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Row untuk Nama Depan & Nama Belakang
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = namaDepan,
                            onValueChange = { namaDepan = it },
                            placeholder = { Text(stringResource(id = R.string.hint_nama_depan)) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        OutlinedTextField(
                            value = namaBelakang,
                            onValueChange = { namaBelakang = it },
                            placeholder = { Text(stringResource(id = R.string.hint_nama_belakang)) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Field Email
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = { Text(stringResource(id = R.string.hint_email)) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Row untuk Tgl Lahir & Experience
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = tglLahir,
                            onValueChange = { tglLahir = it },
                            placeholder = { Text(stringResource(id = R.string.hint_tgl_lahir)) },
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_menu_my_calendar),
                                    contentDescription = null
                                )
                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        OutlinedTextField(
                            value = experience,
                            onValueChange = { experience = it },
                            placeholder = { Text(stringResource(id = R.string.hint_experience)) },
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = android.R.drawable.ic_menu_send),
                                    contentDescription = null
                                )
                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Label Pilih Skill
                    Text(
                        text = stringResource(id = R.string.label_pilih_skill),
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 14.sp,
                        color = colorResource(id = android.R.color.black)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Checkbox Pilihan Skill
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(checked = isAndroidChecked, onCheckedChange = { isAndroidChecked = it })
                            Text(text = stringResource(id = R.string.skill_android), fontSize = 12.sp)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(checked = isUiUxChecked, onCheckedChange = { isUiUxChecked = it })
                            Text(text = stringResource(id = R.string.skill_ui_ux), fontSize = 12.sp)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(checked = isWebChecked, onCheckedChange = { isWebChecked = it })
                            Text(text = stringResource(id = R.string.skill_web), fontSize = 12.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Tombol Proceed
                    Button(
                        onClick = { /* Aksi ketika tombol diklik */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.button_background)
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.btn_proceed),
                            color = colorResource(id = R.color.button_text_color),
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}

// comit 1
// comit 2
// comit 3
// Aplikasi Android