import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart';

import '../api_model/student.dart';

class StudentsList extends StatefulWidget {
  StudentsList({super.key, required this.classId});
  final int classId;

  @override
  StudentsListState createState() => StudentsListState();
}

class StudentsListState extends State<StudentsList> {
  final List<Student> _students = <Student>[];

  @override
  void initState() {
    super.initState();
    _getStudents();
  }

  Future<void> _getStudents() async {
    setState(() {
      _students.clear();
    });

    final Client client = Client();
    final Uri uri = Uri.http('localhost:8080', '/assistant/users/students/?class-id=${widget.classId}');

    final Response response = await client.get(uri);

    if (response.statusCode == 200) {
      final List<dynamic> data = jsonDecode(response.body) as List<dynamic>;

      setState(() {
        for (int i = 0; i < data.length; i++) {
          final Map<String, dynamic> student = data[i] as Map<String, dynamic>;
          final Student item = Student(
              email: student['email'] as String,
              firstname: student['firstname'] as String,
              lastname: student['lastname'] as String,
              idClass: student['assignedClass']['id'] as int);
          _students.add(item);
        }
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Lista Elevi'),
      ),
      body: ColoredBox(
        color: Colors.purple,
        child: GridView.builder(
            itemCount: _students.length,
            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 1),
            itemBuilder: (BuildContext context, int index) {
              final Student student = _students[index];
              return Stack(fit: StackFit.expand, children: <Widget>[
                Align(
                    alignment: AlignmentDirectional.bottomEnd,
                    child: ListTile(
                      title: Text('${student.firstname} ${student.lastname}')
                    ),
                    )
              ]);
            })
      ),
    );
  }
}