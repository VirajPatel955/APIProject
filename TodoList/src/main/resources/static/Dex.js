// const mysql =require('mysql');
// const express = require('express');
// var app = express();
// const bodyparser = require('body-parser');

// app.use(bodyparser.json());


// var mysqlConnection = mysql.createConnection({
//     host: 'localhost',
//     user : 'root',
//     password: 'Password123',
//     database : 'pokedexdb',
//     multipleStatements: true
// });

// mysqlConnection.connect((err) => {
//     if (!err)
//         console.log('DB connection succeded.');
//     else
//         console.log('DB connection failed \n Error : ' + JSON.stringify(err, undefined, 2));
// });

// app.listen(8080, () => console.log('Express server is running at port no : 8080'));

// //Get All Pokemon
// app.get('/GetPokemon', (req, res) => {
//     mysqlConnection.query('SELECT * FROM pokedex', (err, rows, fields)=>{
//         if (!err)
//         res.send(rows);
//         else
//         console.log(err);
//     })
// });

// //Get Pokemon from dex_id
// app.get('/GetPokemon/:dex_id', (req, res) => {
//     mysqlConnection.query('SELECT * FROM pokedex WHERE dex_id = ?', [req.params.dex_id], (err, rows, fields) => {
//         if (!err)
//             res.send(rows);
//         else
//             console.log(err);
//     })
// });

// //Delete Pokemon with Dex_id
// app.delete('/deletePokemon/dex_id', (req, res) => {
//     mysqlConnection.query('DELETE FROM pokedex WHERE dex_id = ?', [req.params.dex_id], (err, rows, fields) => {
//         if (!err)
//             res.send('Deleted successfully.');
//         else
//             console.log(err);
//     })
// });

// //INSERT an Pokemon
// app.post('/AddPokemon', (req, res) => {
//     let poke = req.body;
//     var sql = "SET @dex_id = ?;SET @pokemon = ?;SET @description= ?; SET @caught= ?\
//     CALL PokedexAddOrEdit(@dex_id,@pokemon,@description,@caught);";
//     mysqlConnection.query(sql, [poke.dex_id, poke.pokemon, poke.description, poke.caught], (err, rows, fields) => {
//         if (!err)
//             rows.forEach(element => {
//                 if(element.constructor == Array)
//                 res.send('Inserted  dex_id : '+element[0].dex_id);
//             });
//         else
//             console.log(err);
//         })

//     });

//     //Updat a Pokemon
//     app.put('/UpdatePokemon', (req, res) => {
//         let poke = req.body;
//         var sql = "SET @dex_id = ?;SET @pokemon = ?;SET @description= ?; SET @caught= ?\
//         CALL PokedexAddOrEdit(@dex_id,@pokemon,@description,@caught);";
//         mysqlConnection.query(sql, [poke.dex_id, poke.pokemon, poke.description, poke.caught], (err, rows, fields) => {
//             if (!err)
//                 res.send('Update Successfully');
//             else
//                 console.log(err);
//             })
    
//         });
        
const url = "http://localhost:8086/pokedex";
const GetPokemon = () => {
	
	fetch(`${url}/GetPokemon`)
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {				
                appendData(data);
            })
            .catch(function (err) {
                console.log('error: ' + err);
            });
        };

GetPokemon();







