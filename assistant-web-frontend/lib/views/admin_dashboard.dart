class AdminDashboard extends StatefulWidget {
  const AdminDashboard({super.key});

  @override
  State<AdminDashboard> createState() => _AdminDashboardState();
}


class _AdminDashboardState extends State<AdminDashboard> {

  final TextEditingController _searchController = TextEditingController();

  bool _isLoading = false;
  bool _updating = false;
  String _searchQuery = '';

  @override
  void initState() {
    super.initState();
    void _showMenu() {
      if (_updating) {
        return;
      }
      setState(() {
        _updating = true;
        showDialog(

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
                                MaterialPageRoute<ListaLectiiPage>(
                                    builder: (BuildContext context) => const ListaLectiiPage()),
                              );
                            },
                            child: const InfoCard(

                              label: 'Adauga Profesor',
                              amount: 'incarca csv...',
                            ),
                          ),
                          GestureDetector(
                            onTap: () {
                              Navigator.push(
                                context,
                                MaterialPageRoute<ListaTemePage>(
                                    builder: (BuildContext context) => const ListaTemePage()),
                              );
                            },
                            child: const InfoCard(

                              label: 'Adauga studenti',
                              amount: 'incarca csv...',
                            ),
                          ),
                          GestureDetector(
                            onTap: () {
                              Navigator.push(
                                context,
                                MaterialPageRoute<ListaQuizPage>(
                                    builder: (BuildContext context) => const ListaQuizPage()),
                              );
                            },
                            child: const InfoCard(

                              label: 'Adauga clasa',
                              amount: 'incarca csv...',
                            ),
                          ),
                          GestureDetector(
                            onTap: () {
                              Navigator.push(
                                context,
                                MaterialPageRoute<ListaNotePage>(
                                    builder: (BuildContext context) => const ListaNotePage()),
                              );
                            },
                            child: const InfoCard(

                              label: 'Atribuie profesor unei clase',
                              amount: 'incarca csv...',
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
                      child: const Text('Iesire'))
                ],
              );
            });
      });
    }

  }
}
