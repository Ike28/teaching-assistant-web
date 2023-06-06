import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart';

import '../api_model/subject.dart';
import '../component/teacher_dashboard/header.dart';
import '../component/teacher_dashboard/info_card.dart';
import '../config/size_config.dart';

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
        child:  ListView(
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
  const StudentDashboard({super.key});

  @override
  State<StudentDashboard> createState() => _StudentDashboardState();
}

class _StudentDashboardState extends State<StudentDashboard> {
  final List<Subject> _subjects = <Subject>[];
  final TextEditingController _searchController = TextEditingController();

  bool _isLoading = false;
  bool _updating = false;
  String _searchQuery = '';

  @override
  void initState() {
    super.initState();
    _getSubjects();
  }

  Future<void> _getSubjects() async {
    setState(() {
      _isLoading = true;
      _subjects.clear();
    });
    final Client client = Client();
    final Uri uri = Uri.http('localhost:8080', '/contest/subjects');

    final Response response = await client.get(uri);

    if (response.statusCode == 200) {
      final List<dynamic> data = jsonDecode(response.body) as List<dynamic>;
      final List<dynamic> results = data;

      setState(() {
        for (int i = 0; i < results.length; i++) {
          final Map<String, dynamic> subject = results[i] as Map<String, dynamic>;
          final Subject item = Subject(
              id: subject['id'] as String,
              name: subject['name'] as String);
          _subjects.add(item);
        }
        _isLoading = false;
      });
    }
  }


  Future<void> _getSubjectByName({required String name}) async {
    setState(() {
      _isLoading = true;
      _subjects.clear();
    });
    final Client client = Client();
    final Uri uri = Uri.http('localhost:8080', '/contest/subjects/$name');

    final Response response = await client.get(uri);

    if (response.statusCode == 404) {
      setState(() {
        _isLoading = false;
      });
    }

    if (response.statusCode == 200) {
      final Map<String, dynamic> subject = jsonDecode(response.body) as Map<
          String,
          dynamic>;

      setState(() {
        final Subject item = Subject(
            id: subject['id'] as String,
            name: subject['name'] as String);
        _subjects.add(item);
        _isLoading = false;
      });
    }
  }

  void _showMenu() {
    if (_updating) {
      return;
    }
    setState(() {
      _updating = true;
      showDialog(
          context: context,
          builder: (BuildContext context) {
            return AlertDialog(
              title: const Text('Materie:'),
              content: Column(
                children: <Widget>[
                  const Header(),
                  SizedBox(
                    height: SizeConfig.blockSizeVertical * 4,
                  ),
                  SizedBox(
                    width: SizeConfig.screenWidth,
                    child: Wrap(
                      spacing: 20,
                      runSpacing: 20,
                      alignment: WrapAlignment.spaceBetween,
                      children: <Widget>[
                        GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute<ListaLectiiPage>(builder: (BuildContext context) => const ListaLectiiPage()),
                            );
                          },
                          child: const InfoCard(
                            icon: 'assets/lesson.svg',
                            label: 'Lectii',
                            amount: '>',
                          ),
                        ),
                        GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute<ListaTemePage>(builder: (BuildContext context) => const ListaTemePage()),
                            );
                          },
                          child: const InfoCard(
                            icon: 'assets/teme.svg',
                            label: 'Teme',
                            amount: '>',
                          ),
                        ),
                        GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute<ListaQuizPage>(builder: (BuildContext context) => const ListaQuizPage()),
                            );
                          },
                          child: const InfoCard(
                            icon: 'assets/quiz.svg',
                            label: 'Quizuri',
                            amount: '>',
                          ),
                        ),
                        GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute<ListaNotePage>(builder: (BuildContext context) => const ListaNotePage()),
                            );
                          },
                          child: const InfoCard(
                            icon: 'assets/note.svg',
                            label: 'Note',
                            amount: '>',
                          ),
                        ),
                      ],
                    ),
                  ),
                  SizedBox(
                    height: SizeConfig.blockSizeVertical * 4,
                  ),
                ],
              ),
              actions: <Widget>[
                TextButton(
                    onPressed: () {
                      _updating = false;
                      Navigator.of(context).pop();
                    },
                    child: const Text('Iesire')
                )
              ],
            );
          });
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
                        _getSubjects();
                      } else {
                        _getSubjectByName(name: _searchQuery);
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
              child: _subjects.isNotEmpty
                  ? GridView.builder(
                  itemCount: _subjects.length,
                  gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 4),
                  itemBuilder: (BuildContext context, int index) {
                    final Subject subject = _subjects[index];
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
                              title: Text(subject.name),
                              subtitle: Text('id #${subject.id}'),
                              onTap: () {
                                _showMenu();
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
