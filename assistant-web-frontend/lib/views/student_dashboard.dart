import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart';

import '../api_model/course.dart';
import '../api_model/student.dart';
import 'subject_menu.dart';

class ListaLectiiPage extends StatefulWidget {
  const ListaLectiiPage({super.key});

  @override
  ListaLectiiPageState createState() => ListaLectiiPageState();
}

class ListaLectiiPageState extends State<ListaLectiiPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Lista Lectii'),
      ),
      body: ColoredBox(
        color: Colors.purple,
        child: ListView(
          children: <ListTile>[
            ListTile(
              title: const Text('Lectia 1'),
              onTap: () {
                // Implementează acțiunea de navigare către detalii pentru lectia 1
                // poți utiliza Navigator.push pentru a deschide o nouă pagină
                // unde vei afișa detaliile despre lectia respectivă.
              },
            ),
            ListTile(
              title: const Text('Lectia 2'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: const Text('Lectia 3'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: const Text('Lectia 4'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: const Text('Lectia 5'),
              onTap: () {
                // to do
              },
            ),
          ],
        ),
      ),
    );
  }
}

class ListaTemePage extends StatefulWidget {
  const ListaTemePage({super.key});

  @override
  ListaTemePageState createState() => ListaTemePageState();
}

class ListaTemePageState extends State<ListaTemePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Lista Teme'),
      ),
      body: ColoredBox(
        color: Colors.purple,
        child: ListView(
          children: <ListTile>[
            ListTile(
              title: const Text('Tema 1'),
              onTap: () {
                // Implementează acțiunea de navigare către detalii pentru lectia 1
                // poți utiliza Navigator.push pentru a deschide o nouă pagină
                // unde vei afișa detaliile despre lectia respectivă.
              },
            ),
            ListTile(
              title: const Text('Tema 2'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: const Text('Tema 3'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: const Text('Tema 4'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: const Text('Tema 5'),
              onTap: () {
                // to do
              },
            ),
          ],
        ),
      ),
    );
  }
}

class ListaQuizPage extends StatefulWidget {
  const ListaQuizPage({super.key});

  @override
  ListaQuizPageState createState() => ListaQuizPageState();
}

class ListaQuizPageState extends State<ListaQuizPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Lista Quizuri'),
      ),
      body: ColoredBox(
        color: Colors.purple,
        child: ListView(
          children: <ListTile>[
            ListTile(
              title: const Text('Quiz 1'),
              onTap: () {
                // Implementează acțiunea de navigare către detalii pentru lectia 1
                // poți utiliza Navigator.push pentru a deschide o nouă pagină
                // unde vei afișa detaliile despre lectia respectivă.
              },
            ),
            ListTile(
              title: const Text('Quiz 2'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: const Text('Quiz 3'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: const Text('Quiz 4'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: const Text('Quiz 5'),
              onTap: () {
                // to do
              },
            ),
          ],
        ),
      ),
    );
  }
}

class ListaNotePage extends StatefulWidget {
  const ListaNotePage({super.key});

  @override
  ListaNotePageState createState() => ListaNotePageState();
}

class ListaNotePageState extends State<ListaNotePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Lista Note'),
      ),
      body: ColoredBox(
        color: Colors.purple,
        child: ListView(
          children: <ListTile>[
            ListTile(
              title: const Text('<20/01/2023> Nota 10'),
              onTap: () {
                // Implementează acțiunea de navigare către detalii pentru lectia 1
                // poți utiliza Navigator.push pentru a deschide o nouă pagină
                // unde vei afișa detaliile despre lectia respectivă.
              },
            ),
            ListTile(
              title: const Text('<25/01/2023> Nota 9'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: const Text('<08/02/2023> Nota 8'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: const Text('<16/03/2023> Nota 10'),
              onTap: () {
                // to do
              },
            ),
          ],
        ),
      ),
    );
  }
}

class StudentDashboard extends StatefulWidget {
  const StudentDashboard({super.key, required this.student});
  final Student student;

  @override
  State<StudentDashboard> createState() => _StudentDashboardState();
}

class _StudentDashboardState extends State<StudentDashboard> {
  final List<Course> _courses = <Course>[];
  final TextEditingController _searchController = TextEditingController();

  bool _isLoading = false;
  bool _updating = false;
  String _searchQuery = '';

  @override
  void initState() {
    super.initState();
    _getCourses();
  }

  Future<void> _getCourses() async {
    setState(() {
      _isLoading = true;
      _courses.clear();
    });

    final Client client = Client();
    final Uri uri = Uri.http('localhost:8080', '/assistant/courses/?class-id=${widget.student.idClass}');

    final Response response = await client.get(uri);

    if (response.statusCode == 200) {
      final List<dynamic> data = jsonDecode(response.body) as List<dynamic>;

      setState(() {
        for (int i = 0; i < data.length; i++) {
          final Map<String, dynamic> course = data[i] as Map<String, dynamic>;
          final Course item = Course(
              id: course['id'] as int,
              teacherId: course['professor']['id'] as int,
              classId: course['courseClass']['id'] as int,
              subjectId: course['subject']['id'] as int,
              name: course['subject']['name'] as String
          );
          _courses.add(item);
        }
      });
    }

    _isLoading = false;
  }

  Future<void> _getCourseByName({required String name}) async {
    setState(() {
      _isLoading = true;
      _courses.clear();
    });
    final Client client = Client();
    final Uri uri = Uri.http('localhost:8080', '/assistant/courses/?class-id=${widget.student.idClass}&name=$name');

    final Response response = await client.get(uri);

    if (response.statusCode == 404) {
      setState(() {
        _isLoading = false;
      });
    }

    if (response.statusCode == 200) {
      final Map<String, dynamic> course = jsonDecode(response.body) as Map<String, dynamic>;

      setState(() {
        final Course item = Course(
            id: course['id'] as int,
            teacherId: course['professor']['id'] as int,
            classId: course['courseClass']['id'] as int,
            subjectId: course['subject']['id'] as int,
            name: course['subject']['name'] as String);
        _courses.add(item);
      });
    }

    _isLoading = false;
  }

  void _showMenu(final Course course) {
    if (_updating) {
      return;
    }
    setState(() {
      Navigator.push(
          context, MaterialPageRoute<SubjectMenu>(
          builder: (BuildContext context) => SubjectMenu(course: course)));
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Materiale'),
          actions: <Widget>[
            if (_isLoading)
              const Center(
                child: FittedBox(
                  child: Padding(
                    padding: EdgeInsets.all(16),
                    child: CircularProgressIndicator(),
                  ),
                ),
              )
          ],
        ),
        body: _isLoading
            ? const Center(
                child: CircularProgressIndicator(),
              )
            : Column(
                children: <Widget>[
                  Row(
                    children: <Widget>[
                      Expanded(
                          child: TextField(
                        controller: _searchController,
                        decoration: const InputDecoration(
                            label: Text('Cauta materie'),
                            prefixIcon: Icon(Icons.search),
                            prefixIconColor: Colors.purple),
                      )),
                      TextButton(
                          onPressed: () {
                            _searchQuery = _searchController.text;
                            if (_searchQuery.isEmpty) {
                              _getCourses();
                            } else {
                              _getCourseByName(name: _searchQuery);
                            }
                          },
                          style: TextButton.styleFrom(backgroundColor: Colors.purple, foregroundColor: Colors.white),
                          child: const Text('Cautare')),
                    ],
                  ),
                  const SizedBox(
                    height: 10,
                  ),
                  Expanded(
                    child: _courses.isNotEmpty
                        ? GridView.builder(
                            itemCount: _courses.length,
                            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 4),
                            itemBuilder: (BuildContext context, int index) {
                              final Course course = _courses[index];
                              return Stack(fit: StackFit.expand, children: <Widget>[
                                Align(
                                    alignment: AlignmentDirectional.bottomEnd,
                                    child: Container(
                                      decoration: const BoxDecoration(
                                          gradient: LinearGradient(
                                              begin: AlignmentDirectional.bottomCenter,
                                              end: AlignmentDirectional.topCenter,
                                              colors: <Color>[Colors.purple, Colors.transparent])),
                                      child: ListTile(
                                        title: Text(course.name),
                                        subtitle: Text('id #${course.id}'),
                                        onTap: () {
                                          _showMenu(course);
                                        },
                                      ),
                                    ))
                              ]);
                            })
                        : const Center(
                            child: CircularProgressIndicator(semanticsLabel: 'Se incarca materiile...'),
                          ),
                  )
                ],
              ));
  }
}
