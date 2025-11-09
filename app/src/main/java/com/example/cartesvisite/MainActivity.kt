package com.example.cartesvisite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartesvisite.ui.theme.CartesVisiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartesVisiteTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    // Dégradé principal de fond
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF606C38), // Vert olive foncé
                        Color(0xFFFFFFFF)  // Blanc
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color.White)
                .fillMaxWidth(0.9f)
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- Partie haute : Profil ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF606C38))
                    .padding(vertical = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.android_logo),
                        contentDescription = "Profile picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "DINGUEMNODJI YOUSSOUF",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "Développeur Fullstack",
                        fontSize = 16.sp,
                        color = Color(0xFFDDE5B6)
                    )
                }
            }

            // --- Partie basse : Coordonnées ---
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                ContactInfo(
                    icon = Icons.Filled.Phone,
                    text = "+225 07 89 68 16 13",
                    iconColor = Color(0xFF606C38)
                )
                ContactInfo(
                    icon = Icons.Filled.Share,
                    text = "@you_soft",
                    iconColor = Color(0xFF606C38)
                )
                ContactInfo(
                    icon = Icons.Filled.Email,
                    text = "yousoft@mail.com",
                    iconColor = Color(0xFF606C38)
                )
            }
        }
    }
}

@Composable
fun ContactInfo(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    iconColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5)
        ),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                fontSize = 15.sp,
                color = Color(0xFF333333)
            )
        }
    }
}
