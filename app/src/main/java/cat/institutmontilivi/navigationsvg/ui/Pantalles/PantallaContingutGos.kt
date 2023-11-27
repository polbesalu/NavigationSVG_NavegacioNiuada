package cat.institutmontilivi.navigation3.ui.Pantalles

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.navigation3.Dades.Cotxes
import cat.institutmontilivi.navigation3.Dades.Gossos
import cat.institutmontilivi.navigation3.Dades.Guerrers
import cat.institutmontilivi.navigationsvg.R
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun PantallaContingutGos(id: Int){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
        ){
            val gos = Gossos.dades.find{it.id == id}
            Log.d("BESALU","conté la id correcta del gos -> $id")

            if (gos != null) {
                Text(
                    stringResource(R.string.nom) + gos.nom, modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(gos.foto)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = stringResource(R.string.gos),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .weight(4F)
                )
                Text(text = stringResource(R.string.id_del_gos) + gos.id.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(7.dp))

                Text(text = stringResource(R.string.puntuaci_del_gos) + gos.puntuacio.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                LinearProgressIndicator(progress = gos.puntuacio.toFloat()/10, modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }