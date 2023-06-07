import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart';

import '../api_model/student.dart';
import '../component/teacher_login/login_button.dart';
import '../component/teacher_login/login_field.dart';
import '../component/teacher_login/social_login_button.dart';
import '../config/api_utils.dart';
import '../style/palette.dart';
import 'login_teacher.dart';
import 'student_dashboard.dart';

class StudentLogin extends StatelessWidget {
  StudentLogin({super.key});
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  Future<Student?> connect() async {
    final String email = _emailController.text;
    final String password = _passwordController.text;

    final Response response = await ApiUtils.post(
        path: '/assistant/users/students/login', jsonData: <String, dynamic>{'email': email, 'password': password});
    if (response.statusCode == 200) {
      final Map<String, dynamic> student = jsonDecode(response.body) as Map<String, dynamic>;
      final Student foundStudent = Student(
          id: student['id'] as int,
          email: student['email'] as String,
          firstname: student['firstname'] as String,
          lastname: student['lastname'] as String,
          idClass: student['assignedClass']['id'] as int);
      return foundStudent;
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
                SocialLoginButton(
                    iconPath: 'assets/svg/elevi_login_logo.svg',
                    label: 'Conectare cadre didactice',
                    onPressed: () {
                      Navigator.push(
                          context, MaterialPageRoute<TeacherLogin>(
                          builder: (BuildContext context) => TeacherLogin()));
                    },
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
                    text: 'Conectare elev',
                    onPressed: () async {
                  final Student? foundStudent = await connect();
                  if (foundStudent != null) {
                    Navigator.push(
                        context,
                        MaterialPageRoute<StudentDashboard>(
                            builder: (BuildContext context) => StudentDashboard(student: foundStudent)));
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
