import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart';

import '../api_model/teacher.dart';
import '../component/teacher_login/login_button.dart';
import '../component/teacher_login/login_field.dart';
import '../component/teacher_login/social_login_button.dart';
import '../config/api_utils.dart';
import '../style/palette.dart';
import 'login_student.dart';
import 'teacher_dashboard.dart';

class TeacherLogin extends StatelessWidget {
  TeacherLogin({super.key});
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  Future<Teacher?> connect() async {
    final String email = _emailController.text;
    final String password = _passwordController.text;

    final Response response = await ApiUtils.post(
        path: '/assistant/users/teachers/login', jsonData: <String, dynamic>{'email': email, 'password': password});
    if (response.statusCode == 200) {
      final Map<String, dynamic> teacher = jsonDecode(response.body) as Map<String, dynamic>;
      final Teacher foundTeacher = Teacher(
          id: teacher['id'] as int,
          email: teacher['email'] as String,
          password: teacher['password'] as String,
          firstname: teacher['firstname'] as String,
          lastname: teacher['lastname'] as String);
      return foundTeacher;
    }
    return null;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ColoredBox(
        color: Palette.backgroundColor,
        child: SingleChildScrollView(
          child: Center(
            child: Column(
              children: <Widget>[
                Image.asset('assets/img/sign_in.png'),
                const Text(
                  'Bun venit',
                  style: TextStyle(fontWeight: FontWeight.bold, fontSize: 50, color: Palette.whiteColor),
                ),
                const SizedBox(height: 50),
                SocialLoginButton(iconPath: 'assets/svg/elevi_login_logo.svg', label: 'Conectare elevi',
                  onPressed: () {
                    Navigator.push(
                        context, MaterialPageRoute<StudentLogin>(
                        builder: (BuildContext context) => StudentLogin()));
                  }
                ),
                const SizedBox(height: 20),
                SocialLoginButton(
                  iconPath: 'assets/svg/admin_login_logo.svg',
                  label: 'Conectare administratori',
                  horizontalPadding: 90,
                  onPressed: () {
                    Navigator.push(
                        context, MaterialPageRoute<StudentLogin>(
                        builder: (BuildContext context) => StudentLogin()));
                  },
                ),
                const SizedBox(height: 15),
                const Text(
                  'sau',
                  style: TextStyle(
                    fontSize: 17,
                  ),
                ),
                const SizedBox(height: 15),
                LoginField(hintText: 'Email', obscure: false, controller: _emailController),
                const SizedBox(height: 15),
                LoginField(hintText: 'Parolă', obscure: true, controller: _passwordController),
                const SizedBox(height: 20),
                LoginButton(
                    text: 'Conectare cadru didactic',
                    onPressed: () async {
                  final Teacher? foundTeacher = await connect();
                  if (foundTeacher != null) {
                    Navigator.push(
                        context,
                        MaterialPageRoute<TeacherDashboard>(
                            builder: (BuildContext context) => TeacherDashboard(teacher: foundTeacher)));
                  }
                }),
                const SizedBox(height: 100)
              ],
            ),
          ),
        ),
      ),
    );
  }
}
