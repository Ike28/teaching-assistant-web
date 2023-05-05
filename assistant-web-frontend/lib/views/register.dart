// ignore_for_file: use_build_context_synchronously

import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:http/http.dart' as http;

import '../api_model/user.dart';

class Register extends StatefulWidget {
  const Register({super.key});

  @override
  State<Register> createState() => _RegisterState();
}

class _RegisterState extends State<Register> {
  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  User user = User('', '');
  final Uri uri = Uri(scheme: 'http', host: 'localhost', port: 8000, path: '/register');

  Future<void> save() async {
    await http.post(uri,
        headers: <String, String>{'Content-Type': 'application/json'},
        body: json.encode(<String, String>{'email': user.email, 'password': user.password}));
    Navigator.pop(context);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Form(
            key: _formKey,
            child: Column(
              children: <Widget>[
                Container(
                  height: 750,
                  width: MediaQuery.of(context).size.width,
                  decoration: const BoxDecoration(
                    color: Color.fromRGBO(233, 65, 82, 1),
                    boxShadow: <BoxShadow>[BoxShadow(blurRadius: 10, offset: Offset(1, 4))],
                    borderRadius: BorderRadius.only(bottomLeft: Radius.circular(30), bottomRight: Radius.circular(30)),
                  ),
                  child: Padding(
                    padding: const EdgeInsets.all(16.0),
                    child: Column(
                      children: <Widget>[
                        const SizedBox(
                          height: 100,
                        ),
                        Text('Register',
                            style: GoogleFonts.pacifico(
                              fontWeight: FontWeight.bold,
                              fontSize: 50,
                              color: Colors.white,
                            )),
                        const SizedBox(
                          height: 30,
                        ),
                        Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            'Email',
                            style: GoogleFonts.roboto(
                              // fontWeight: FontWeight.bold,
                              fontSize: 40,
                              color: const Color.fromRGBO(255, 255, 255, 0.8),
                            ),
                          ),
                        ),
                        TextFormField(
                          controller: TextEditingController(text: user.email),
                          onChanged: (String val) {
                            user.email = val;
                          },
                          validator: (String? value) {
                            if (value != null) {
                              if (value.isEmpty) {
                                return 'Email is empty';
                              }
                            }
                            return null;
                          },
                          style: const TextStyle(fontSize: 30, color: Colors.white),
                          decoration: const InputDecoration(
                              errorStyle: TextStyle(fontSize: 20, color: Colors.black),
                              border: OutlineInputBorder(borderSide: BorderSide.none)),
                        ),
                        Container(
                          height: 8,
                          color: const Color.fromRGBO(255, 255, 255, 0.4),
                        ),
                        const SizedBox(
                          height: 60,
                        ),
                        Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            'Password',
                            style: GoogleFonts.roboto(
                              fontSize: 40,
                              color: const Color.fromRGBO(255, 255, 255, 0.8),
                            ),
                          ),
                        ),
                        TextFormField(
                          obscureText: true,
                          controller: TextEditingController(text: user.password),
                          onChanged: (String val) {
                            user.password = val;
                          },
                          validator: (String? value) {
                            if (value != null) {
                              if (value.isEmpty) {
                                return 'Password is empty';
                              }
                            }
                            return null;
                          },
                          style: const TextStyle(fontSize: 30, color: Colors.white),
                          decoration: const InputDecoration(
                              errorStyle: TextStyle(fontSize: 20, color: Colors.black),
                              border: OutlineInputBorder(borderSide: BorderSide.none)),
                        ),
                        Container(
                          height: 8,
                          color: const Color.fromRGBO(255, 255, 255, 0.4),
                        ),
                        const SizedBox(
                          height: 60,
                        ),
                        Center(
                          child: InkWell(
                            onTap: () {
                              Navigator.pop(context);
                            },
                            child: Text(
                              'Already have Account ?',
                              style: GoogleFonts.roboto(fontWeight: FontWeight.bold, fontSize: 20, color: Colors.white),
                            ),
                          ),
                        )
                      ],
                    ),
                  ),
                ),
                const SizedBox(
                  height: 40,
                ),
                SizedBox(
                  height: 90,
                  width: 90,
                  child: TextButton(
                    onPressed: () {
                      save();
                    },
                    style: ButtonStyle(
                        shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                            RoundedRectangleBorder(borderRadius: BorderRadius.circular(40))),
                        backgroundColor: MaterialStateProperty.all<Color>(const Color.fromRGBO(233, 65, 82, 1))),
                    child: const Icon(
                      Icons.arrow_forward,
                      size: 20,
                      color: Colors.white,
                    ),
                  ),
                )
              ],
            )),
      ),
    );
  }
}