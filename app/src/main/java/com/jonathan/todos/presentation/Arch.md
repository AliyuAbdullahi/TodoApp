#### Android Architectures

#### Popular architectures

1. MVC (Model View Controller)
2. MVP (Model View Presenter)
3. MVVM (Model View ViewModel)
4. MVI (Model View Intent)

##### MVC
In MVC, all business and UI logic happens in controller. The controller
is responsible for data manipulation and presentation.

###### Pros
* It's easy to learn
* It's easy to setup

###### Cons
* Testing is hard
* It can become unmaintenable
* It doesn't scale
* It's just off

##### MVP
In MVP, the business logic is done in repository or interactor while
presentation logic is done in presenter.

###### Pros
* Testing is easy
* It scales
* There is separation of concern between VIEW and PESENTER

###### Cons
* Boiler plate
* If not well managed, memory leak can be introduced


##### MVVM
In MVVM, data logic is done in repository, presentation logic is done in
viewModel. Data is exposed to the UI via state. It is reactive.

###### Pros
* Testing is easy
* There is no state mutation making it robust and solid

##### Cons
* Learning curve

##### MVI
MVI is basically event processing. It tracks event cycle from point of
fire to point of effect. It can be used in combination with MVVM or MVP.

###### Pros
* Easy to test
* It's cool

##### Cons
* Learning curve (it's hard)


### MVP

> Model (Data or <i>Schema</i>)
> View (Displays data)
> Presenter (Presentation logic)

###### Other Entities
> Interactor -> Focused business logic.
> Repository -> Multiple business logic and data manipulation
> Contract -> View <-> Presenter
