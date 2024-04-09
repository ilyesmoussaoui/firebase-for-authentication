package com.ilyes.firebaseauth.auth;

import com.ilyes.firebaseauth.domain.repository.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<AuthRepository> repoProvider;

  public MainViewModel_Factory(Provider<AuthRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static MainViewModel_Factory create(Provider<AuthRepository> repoProvider) {
    return new MainViewModel_Factory(repoProvider);
  }

  public static MainViewModel newInstance(AuthRepository repo) {
    return new MainViewModel(repo);
  }
}
