

class ListaLectiiPage extends StatefulWidget {
  @override
  _ListaLectiiPageState createState() => _ListaLectiiPageState();
}

class _ListaLectiiPageState extends State<ListaLectiiPage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Lista Lectii'),
      ),
      body: Container(
      color: Colors.purple,
        child:  ListView(
          children: [
            ListTile(
              title: Text('Lectia 1'),
              onTap: () {
                // Implementează acțiunea de navigare către detalii pentru lectia 1
                // poți utiliza Navigator.push pentru a deschide o nouă pagină
                // unde vei afișa detaliile despre lectia respectivă.
              },
            ),
            ListTile(
              title: Text('Lectia 2'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: Text('Lectia 3'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: Text('Lectia 4'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: Text('Lectia 5'),
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
  @override
  _ListaTemePageState createState() => _ListaTemePageState();
}

class _ListaTemePageState extends State<ListaTemePage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Lista Teme'),
      ),
      body: Container(
          color: Colors.purple,
          child: ListView(
            children: [
              ListTile(
                title: Text('Tema 1'),
                onTap: () {
                  // Implementează acțiunea de navigare către detalii pentru lectia 1
                  // poți utiliza Navigator.push pentru a deschide o nouă pagină
                  // unde vei afișa detaliile despre lectia respectivă.
                },
              ),
              ListTile(
                title: Text('Tema 2'),
                onTap: () {
                  // to do
                },
              ),
              ListTile(
                title: Text('Tema 3'),
                onTap: () {
                  // to do
                },
              ),
              ListTile(
                title: Text('Tema 4'),
                onTap: () {
                  // to do
                },
              ),
              ListTile(
                title: Text('Tema 5'),
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
  @override
  _ListaQuizPageState createState() => _ListaQuizPageState();
}

class _ListaQuizPageState extends State<ListaQuizPage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Lista Quizuri'),
      ),
      body: Container(
        color: Colors.purple,
        child: ListView(
          children: [
            ListTile(
              title: Text('Quiz 1'),
              onTap: () {
                // Implementează acțiunea de navigare către detalii pentru lectia 1
                // poți utiliza Navigator.push pentru a deschide o nouă pagină
                // unde vei afișa detaliile despre lectia respectivă.
              },
            ),
            ListTile(
              title: Text('Quiz 2'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: Text('Quiz 3'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: Text('Quiz 4'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: Text('Quiz 5'),
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
  @override
  _ListaNotePageState createState() => _ListaNotePageState();
}

class _ListaNotePageState extends State<ListaNotePage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Lista Note'),
      ),
      body: Container(
        color: Colors.purple,
        child: ListView(
          children: [
            ListTile(
              title: Text('<20/01/2023> Nota 10'),
              onTap: () {
                // Implementează acțiunea de navigare către detalii pentru lectia 1
                // poți utiliza Navigator.push pentru a deschide o nouă pagină
                // unde vei afișa detaliile despre lectia respectivă.
              },
            ),
            ListTile(
              title: Text('<25/01/2023> Nota 9'),
              onTap: () {
                // to do
              },
            ),
            ListTile(
              title: Text('<08/02/2023> Nota 8'),
              onTap: () {
                // to do
              },
            ),  1
            ListTile(
              title: Text('<16/03/2023> Nota 10'),
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
  final TextEditingController _nameController = TextEditingController();

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
    final Uri uri = Uri.http('localhost:8080', '/assistant/subjects');

    final Response response = await client.get(uri);

    if (response.statusCode == 200) {
      final List<dynamic> data = jsonDecode(response.body) as List<dynamic>;
      final List<dynamic> results = data;

      setState(() {
        for (int i = 0; i < results.length; i++) {
          final Map<String, dynamic> subject = results[i] as Map<String, dynamic>;
          final Subject item = Subject(
              id: subject['id'] as int,
              name: subject['name'] as String,
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
    final Uri uri = Uri.http('localhost:8080', '/assistant/subjects/?subject-name=$name');

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
            id: subject['id'] as int,
            name: subject['name'] as String,
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
                      children: [
                        GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => ListaLectiiPage()),
                            );
                          },
                          child: InfoCard(
                            icon: 'assets/lesson.svg',
                            label: 'Lectii',
                            amount: '>',
                          ),
                        ),
                        GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => ListaTemePage()),
                            );
                          },
                          child: InfoCard(
                            icon: 'assets/teme.svg',
                            label: 'Teme',
                            amount: '>',
                          ),
                        ),
                        GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => ListaQuizPage()),
                            );
                          },
                          child: InfoCard(
                            icon: 'assets/quiz.svg',
                            label: 'Quizuri',
                            amount: '>',
                          ),
                        ),
                        GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => ListaNotePage()),
                            );
                          },
                          child: InfoCard(
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
                        _getSubjectsByName(name: _searchQuery);
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
                              title: Text('${subject.name}'),
                              subtitle: Text('id #${subject.id}'),
                              onTap: () {
                                _showMenu(id: subject.id, name: subject.name);
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

